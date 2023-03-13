package space.xnet.repotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RepotestApplication

fun main(args: Array<String>) {
	runApplication<RepotestApplication>(*args)
}
