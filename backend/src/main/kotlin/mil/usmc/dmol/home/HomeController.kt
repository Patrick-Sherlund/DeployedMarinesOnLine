package mil.usmc.dmol.home

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/home")
class HomeController(
    private val homeService: HomeService
) {

    @GetMapping("/title")
    fun getHome() =
        homeService.getHomeData()
}