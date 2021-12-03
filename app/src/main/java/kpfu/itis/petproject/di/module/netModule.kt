package kpfu.itis.petproject.di.module

import com.apollographql.apollo.ApolloClient
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kpfu.itis.petproject.BuildConfig
import kpfu.itis.petproject.api.Api
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Modifier

const val APOLLO_CLIENT = "pet_project"

fun netModule() = Kodein.Module(name = "netModule") {
    import(httpModule())

    bind<Gson>() with singleton { provideGson() }
    bind<Retrofit>() with singleton { provideRetrofit(instance(tag = "rest"), instance()) }

    bind<ApolloClient>(tag = APOLLO_CLIENT) with singleton { provideApolloClient(instance(tag = "graphql")) }

    bind<Api>() with singleton { instance<Retrofit>().create(Api::class.java) }
}

private fun provideGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss Z")
    .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
    .create()

private fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.ENDPOINT)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

private fun provideApolloClient(client: OkHttpClient): ApolloClient =
    ApolloClient.builder()
        .serverUrl(BuildConfig.ENDPOINT_JOB)
        .okHttpClient(client)
        .build()
