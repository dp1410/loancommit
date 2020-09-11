package phonepe.ctx;

import javax.inject.Provider;

import com.jarredweb.webjar.service.api.BasicsService;

public interface AppServices {

	Provider<BasicsService> getBasicsService();

	void setBasicsService(Provider<BasicsService> basicsService);

}