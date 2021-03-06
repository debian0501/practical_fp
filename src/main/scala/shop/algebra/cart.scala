package shop.algebra

import shop.domain.cart._
import shop.domain.auth.UserId
import shop.domain.item.ItemId

trait ShoppingCart[F[_]] {
    def get(userId: UserId): F[CartTotal]
    def add(userId: UserId, itemId: ItemId, quantity: Quantity): F[Unit] 
    def delete(userId: UserId): F[Unit]
    def removeItem(userId: UserId, itemId: ItemId): F[Unit]
    def update(userId: UserId, cart: Cart): F[Unit]
}
    