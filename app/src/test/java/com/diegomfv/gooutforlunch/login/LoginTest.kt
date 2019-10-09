package com.diegomfv.gooutforlunch.login

import android.app.Application
import com.diegomfv.gooutforlunch.data.model.domainmodel.login.LoginRequestModel
import com.diegomfv.gooutforlunch.data.model.dto.login.LoginResponseModelDTO
import com.diegomfv.gooutforlunch.data.network.InternetMonitorTool
import com.diegomfv.gooutforlunch.data.service.ErrorService
import com.diegomfv.gooutforlunch.data.service.LoginService
import com.diegomfv.gooutforlunch.data.usecase.LoginUseCase
import com.diegomfv.gooutforlunch.utils.Response
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LoginTest {

    val mockApp: Application = mock()
    val mockLoginService: LoginService = mock()
    val mockErrorService: ErrorService = mock()
    val mockImt: InternetMonitorTool = mock() {
        on { isInternetAvailableRx() } doReturn Observable.just(true)
    }

    lateinit var loginUseCase: LoginUseCase

    @Before
    fun `set Up`() {
        loginUseCase = LoginUseCase(
            mockApp,
            mockLoginService,
            mockErrorService,
            mockImt
        )
    }

    @Test
    fun `test when internet is available login is called`() {

//        whenever(mockImt.isInternetAvailableRx())
//            .thenReturn(Observable.just(true))

        whenever(
            mockLoginService.login(
                argThat { this.isNotBlank() },
                argThat { this.isNotBlank() })
        )
            .thenReturn(Observable.just(Response.Success(LoginResponseModelDTO("FAKE DATA"))))

        loginUseCase.login(LoginRequestModel("user.example@example.com", "abc@@@"))
            .blockingSubscribe {
                assertTrue(it is Response.Success)
                println((it as Response.Success).result.data)
                verify(mockLoginService).login(any(), any())
            }

    }

    @Test
    fun `test when internet is not available login is not called`() {

        whenever(mockImt.isInternetAvailableRx())
            .thenReturn(Observable.just(false))

        whenever(
            mockLoginService.login(
                argThat { this.isNotBlank() },
                argThat { this.isNotBlank() })
        )
            .thenReturn(Observable.just(Response.Failure(RuntimeException("FAKE DATA"))))

        loginUseCase.login(LoginRequestModel("user.example@example.com", "abc@@@"))
            .blockingSubscribe {
                assertTrue(it is Response.Failure)
                verify(mockLoginService, never()).login(any(), any())
            }
    }
}