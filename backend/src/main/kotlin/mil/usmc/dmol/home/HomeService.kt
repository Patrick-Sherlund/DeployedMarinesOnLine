package mil.usmc.dmol.home

import org.springframework.stereotype.Service

@Service
class HomeService(
    private val homeRepository: HomeRepository
) {

    fun getHomeData() = println(homeRepository.findHomeById(1L).get().title)
}