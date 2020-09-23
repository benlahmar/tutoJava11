import httpapi.com.Ihttpservice;
import httpapi.com.providers.Provider1;

module httpmodule {
	exports httpapi.com.providers;
	exports httpapi.com;

	requires java.net.http;
	provides Ihttpservice with Provider1;
}