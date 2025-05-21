import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import pages.PlaywrightLoginPage;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaywrightLoginPageTest {

    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    PlaywrightLoginPage playwrightLoginPage;

    @BeforeAll
    void setupAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void setup() {
        context = browser.newContext();
        page = context.newPage();
        playwrightLoginPage = new PlaywrightLoginPage(page); // Page bilan obyekt yaratilyapti
    }

    @AfterEach
    void cleanUp() {
        if (page != null) page.close();
        if (context != null) context.close();
    }

    @AfterAll
    void tearDownAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @Test
    void loginTest() {
        playwrightLoginPage.navigate();
        playwrightLoginPage.loginAs("user", "user");
        assertTrue(playwrightLoginPage.checkLoginSuccess(), "Login failed");
    }

    @Test
    void invalidCredentialsTest() {
        playwrightLoginPage.navigate();
        playwrightLoginPage.loginAs("wrong", "credentials");
        assertFalse(playwrightLoginPage.checkLoginSuccess(), "Login should be failed");
    }
}
