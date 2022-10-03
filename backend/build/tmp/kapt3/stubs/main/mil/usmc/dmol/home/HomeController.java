package mil.usmc.dmol.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0092\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lmil/usmc/dmol/home/HomeController;", "", "homeService", "Lmil/usmc/dmol/home/HomeService;", "(Lmil/usmc/dmol/home/HomeService;)V", "getHome", "", "backend"})
@org.springframework.web.bind.annotation.RequestMapping(value = {"/api/v1/home"})
@org.springframework.web.bind.annotation.RestController
public class HomeController {
    private final mil.usmc.dmol.home.HomeService homeService = null;
    
    public HomeController(@org.jetbrains.annotations.NotNull
    mil.usmc.dmol.home.HomeService homeService) {
        super();
    }
    
    @org.springframework.web.bind.annotation.GetMapping(value = {"/title"})
    public void getHome() {
    }
}