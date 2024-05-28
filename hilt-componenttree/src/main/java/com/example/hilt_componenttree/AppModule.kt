package com.example.hilt_componenttree

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMemoryIntensiveDependency(): MemoryIntensiveDependency {
        return MemoryIntensiveDependency()
    }

    @Provides
    @Singleton
    fun provideComponentA(componentB: ComponentB): ComponentA {
        return ComponentA(componentB)
    }

    @Provides
    @Singleton
    fun provideComponentB(componentC: ComponentC): ComponentB {
        return ComponentB(componentC)
    }

    @Provides
    @Singleton
    fun provideComponentC(componentD: ComponentD): ComponentC {
        return ComponentC(componentD)
    }

    @Provides
    @Singleton
    fun provideComponentD(componentE: ComponentE): ComponentD {
        return ComponentD(componentE)
    }

    @Provides
    @Singleton
    fun provideComponentE(componentF: ComponentF): ComponentE {
        return ComponentE(componentF)
    }

    @Provides
    @Singleton
    fun provideComponentF(memoryDependency: MemoryIntensiveDependency): ComponentF {
        return ComponentF(memoryDependency)
    }
}