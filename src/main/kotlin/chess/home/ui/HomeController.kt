package chess.home.ui

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("")
    fun home(): String {
        return "/html/index.html"
    }
}
