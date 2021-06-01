package kpfu.itis.petproject.di.module

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

@Suppress("StringLiteralDuplication")
fun httpModule() = Kodein.Module(name = "httpModule") {

    bind<Interceptor>(tag = "logging") with singleton {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
