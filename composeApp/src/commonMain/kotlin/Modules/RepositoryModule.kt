package Modules

import org.koin.dsl.module
import repository.NetworkRepository

val provideRepositoryModule = module {
    single<NetworkRepository> { NetworkRepository(get()) }
}

//Note

//this create koin module for repository
//single: Specifies that NetworkRepository should be a singleton instance. Koin will create only one instance of NetworkRepository and provide the same instance whenever it is requested.
//get(): it retrieves any dependencies required by NetworkRepository. In this case, it implies that NetworkRepository requires another dependency (possibly an HttpClient or similar) to be passed to its constructor.