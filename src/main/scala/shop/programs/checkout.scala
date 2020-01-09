package shop.programs

import shop.domain.auth.UserId
import shop.domain.checkout.Card
import shop.domain.order.OrderId
import shop.http.clients.PaymentClient
import shop.algebra.ShoppingCart
import shop.algebra.Orders
import cats.Monad
import cats.implicits._
import retry.RetryDetails._
import retry._
import io.chrisdavenport.log4cats.Logger
import io.chrisdavenport.log4cats.slf4j.Slf4jLogger


final class CheckoutProgram[F[_]: Monad](paymentClient: PaymentClient[F], shoppingCart: ShoppingCart[F], orders: Orders[F]){


    def checkout(userId: UserId, card: Card): F[OrderId] = 
        for {
            cart <- shoppingCart.get(userId)
            paymentId <- paymentClient.process(userId, cart.total, card)
            orderId <- orders.create(userId, paymentId, cart.items, cart.total)
            _ <- shoppingCart.delete(userId)
        } yield orderId 

    //def logError(action: String)(details: RetryDetails) : F[Unit] = 
    //    details match {
    //        case r: WillDelayAndRetry => 
    //            Logger[F].error(s"Failed on $action. We retried ${r.retriesSoFar} times.")
    //        case g: GivingUp => 
    //            Logger[F].error(s"Giving up on $action after ${g.totalRetries} retries.")
    //}
}