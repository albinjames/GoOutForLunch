package com.diegomfv.gooutforlunch.login

import android.app.Application
import com.diegomfv.gooutforlunch.data.model.domainmodel.login.LoginRequestModel
import com.diegomfv.gooutforlunch.data.model.dto.login.LoginResponseModelDTO
import com.diegomfv.gooutforlunch.data.network.InternetMonitorTool
import com.diegomfv.gooutforlunch.data.service.ErrorService
import com.diegomfv.gooutforlunch.data.service.LoginService
import com.diegomfv.gooutforlunch.data.usecase.LoginUseCase
import com.diegomfv.gooutforlunch.utils.Response
import io.reactivex.Observable
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.lang.RuntimeException

class LoginTest {

    @Mock
    lateinit var mockApp: Application

    @Mock
    lateinit var mockLoginService: LoginService

    @Mock
    lateinit var mockErrorService: ErrorService

    @Mock
    lateinit var mockImt: InternetMonitorTool

    lateinit var loginUseCase: LoginUseCase

    @Before
    fun `set Up`() {
        MockitoAnnotations.initMocks(this)
        loginUseCase = LoginUseCase(
            mockApp,
            mockLoginService,
            mockErrorService,
            mockImt
        )
    }

    @Test
    fun `test when internet is available login is called`() {

        `when`(mockImt.isInternetAvailableRx())
            .thenReturn(Observable.just(true))

        `when`(mockLoginService.login(anyString(), anyString()))
            .thenReturn(
                Observable.just(
                    Response.Success<LoginResponseModelDTO>(
                        LoginResponseModelDTO("FAKE DATA")
                    )
                )
            )

        loginUseCase.login(LoginRequestModel("user.example@example.com", "abc@@@"))
            .blockingSubscribe {
                assertTrue(it is Response.Success)
                verify(mockLoginService).login(anyString(), anyString())
            }
    }

    @Test
    fun `test when internet is not available login is not called`() {

        `when`(mockImt.isInternetAvailableRx())
            .thenReturn(Observable.just(false))

        `when`(mockLoginService.login(anyString(), anyString()))
            .thenReturn(Observable.just(Response.Failure(RuntimeException("FAKE DATA"))))

        loginUseCase.login(LoginRequestModel("user.example@example.com", "abc@@@"))
            .blockingSubscribe {
                assertTrue(it is Response.Failure)
                verify(mockLoginService, never()).login(anyString(), anyString())
            }
    }

//        val loginRequestModelArgument = object : ArgumentMatcher<LoginRequestModel> {
//            override fun matches(argument: LoginRequestModel?): Boolean {
//                return !argument?.email.isNullOrBlank() && !argument?.password.isNullOrBlank()
//            }
//        }

}