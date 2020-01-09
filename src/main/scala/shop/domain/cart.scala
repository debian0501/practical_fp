package shop.domain

import java.util.UUID
import shop.domain.item.ItemId
import shop.domain.item.Item
import squants.market._
import io.estatico.newtype.macros.newtype

object cart {

    @newtype case class Quantity(value: Int)
    @newtype case class Cart(items: Map[ItemId, Quantity]) 
    @newtype case class CartId(value: UUID)
    
    case class CartItem(item: Item, quantity: Quantity)
    case class CartTotal(items: List[CartItem], total: Money)
}