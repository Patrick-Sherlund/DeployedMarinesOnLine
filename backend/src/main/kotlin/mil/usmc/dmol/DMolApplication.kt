package mil.usmc.dmol

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DMolApplication

fun main(args: Array<String>) {
	runApplication<DMolApplication>(*args)
}
