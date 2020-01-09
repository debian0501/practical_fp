package shop.algebra

import shop.domain.brand._

trait Brands[F[_]] {
    def findAll: F[List[Brand]]
    def create(brand: Brand): F[Unit]
}


