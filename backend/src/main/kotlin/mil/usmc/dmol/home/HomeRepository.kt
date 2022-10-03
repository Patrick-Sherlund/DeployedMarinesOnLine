package mil.usmc.dmol.home

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface HomeRepository: JpaRepository<Home, Long> {

    fun findHomeById(id: Long): Optional<Home>

}