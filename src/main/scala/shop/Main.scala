package shop

import cats.effect._
import cats.implicits._
import io.chrisdavenport.log4cats.Logger
import io.chrisdavenport.log4cats.slf4j.Slf4jLogger

object Main extends IOApp {
    implicit val logger = Slf4jLogger.getLogger[IO]

    override def run(args: List[String]): IO[ExitCode] = ???
}