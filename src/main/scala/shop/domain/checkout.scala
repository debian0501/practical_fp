package shop.domain

import io.estatico.newtype.macros.newtype

object checkout {

    @newtype case class Card(card: String)
}