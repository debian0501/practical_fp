package shop.algebra

import shop.domain.category._

trait Categories[F[_]] {
    def findAll: F[List[Category]]
    def create(category: Category): F[Unit]
}