package shop.domain

import io.estatico.newtype.macros.newtype
import java.util.UUID

object category {

    @newtype case class Category(value: String)
    @newtype case class CategoryId(value: UUID)
}