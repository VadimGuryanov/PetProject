package kpfu.itis.petproject.di.module

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import java.util.concurrent.TimeUnit

@Suppress("StringLiteralDuplication")
fun httpModule() = Kodein.Module(name = "httpModule") {

    bind<Interceptor>(tag = "logging") with singleton {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    bind<OkHttpClient>(tag = "rest") with singleton {
        provideOkHttpClient(loggingInterceptor = instance(tag = "logging"))
    }
}

private fun provideOkHttpClient(
    loggingInterceptor: Interceptor
): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
    .addInterceptor(loggingInterceptor)
    .build()

private const val TIMEOUT_READ = 30L

