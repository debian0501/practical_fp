package shop.algebra

import shop.domain.auth._

trait Users[F[_]] { 
    def find(username: UserName, password: Password): F[Option[User]]
    def create(username: UserName, password: Password): F[UserId]
}
