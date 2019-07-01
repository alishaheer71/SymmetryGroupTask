package task.symmetrygroup;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements okhttp3.Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("device-platform", "android")
                .addHeader("Acess token", "ca673712338e7b964e5267a261f8abdc")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0 ipadedetailerandroidapp")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}