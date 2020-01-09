package shop.http.clients

import shop.domain.auth.UserId
import squants.market._
import shop.domain.checkout.Card
import shop.domain.order.PaymentId

trait PaymentClient[F[_]] { 
    def process(userId: UserId, total: Money, card: Card): F[PaymentId]
}