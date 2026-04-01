package com.example.demomobilebanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.demomobilebanking.ui.enrollment.ScreenEnrollment
import com.example.demomobilebanking.ui.forgetpassword.ForgetPassword
import com.example.demomobilebanking.ui.forgetpassword.ResetPWSuccess
import com.example.demomobilebanking.ui.forgetpassword.ResetPassword
import com.example.demomobilebanking.ui.forgetpassword.ScreenConfirmOTP
import com.example.demomobilebanking.ui.forgetpassword.ScreenResetPassword
import com.example.demomobilebanking.ui.forgetpassword.ScreenResult
import com.example.demomobilebanking.ui.home.DashBoard
import com.example.demomobilebanking.ui.home.ScreenHomeDashBoard
import com.example.demomobilebanking.ui.log_in.ConfirmOTP
import com.example.demomobilebanking.ui.log_in.FaceID
import com.example.demomobilebanking.ui.log_in.Login
import com.example.demomobilebanking.ui.log_in.OnBoarding
import com.example.demomobilebanking.ui.log_in.RepeatPIN
import com.example.demomobilebanking.ui.log_in.ScreenBiometry
import com.example.demomobilebanking.ui.log_in.ScreenDeviceBinding
import com.example.demomobilebanking.ui.log_in.ScreenLogIn
import com.example.demomobilebanking.ui.log_in.ScreenRepeatPIN
import com.example.demomobilebanking.ui.log_in.ScreenSetPin
import com.example.demomobilebanking.ui.log_in.ScreenStart
import com.example.demomobilebanking.ui.log_in.SetPIN
import com.example.demomobilebanking.ui.theme.DemoMobileBankingTheme
import com.example.demomobilebanking.ui.transfer.MenuTransfer
import com.example.demomobilebanking.ui.transfer.ScreenMenuTransfer
import com.example.demomobilebanking.ui.transfer.ScreenTransferToOwnAccount
import com.example.demomobilebanking.ui.transfer.TransferToOwnAccount

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContent {
            val backstack = rememberNavBackStack(TransferToOwnAccount) // For the first start screen. *OnBoarding Screen is the key first start screen

            NavDisplay(
                backStack = backstack,
                onBack = {
                    backstack.removeLastOrNull()
                },
                entryProvider = entryProvider {
                    entry<OnBoarding> {
                        ScreenStart(
                            onStartLoginClick = {
                                backstack.add(
                                    element = Login
                                )
                            },
                            onEnrollmentClick = {
                                backstack.add(
                                    element = ScreenEnrollment
                                )
                            }
                        )
                    }
                    entry<Login> {
                        ScreenLogIn(
                            onLoginSuccessClick = {
                                backstack.add(
                                    element = ConfirmOTP
                                )
                            },
                            onBack = {backstack.removeLastOrNull()},
                            onForgotPassword = {
                                backstack.add(
                                    element = ForgetPassword
                                )
                            }
                        )
                    }
                    entry <ConfirmOTP>{
                        ScreenDeviceBinding(
                            confirmOTP = {
                                backstack.add(
                                    element = SetPIN
                                )
                            }
                        )
                    }
                    entry <ScreenEnrollment>{
                        ScreenEnrollment(
                            onEnrollConfirm = {
                                backstack.add(
                                    element = ForgetPassword
                                )
                            }
                        )
                    }
                    entry<SetPIN> {
                        ScreenSetPin(
                            completedSetPIN = {
                                backstack.add(
                                    element = RepeatPIN
                                )
                            }
                        )
                    }
                    entry<FaceID>{
                        ScreenBiometry()
                    }
                    entry<RepeatPIN>{
                        ScreenRepeatPIN(
                            completedRepeatPIN = {
                                backstack.add(
                                    element = FaceID
                                )
                            }
                        )
                    }
                    entry <ForgetPassword>{
                        ScreenConfirmOTP(
                            forgotPasswordOTP = {
                                backstack.add(
                                    element = ResetPassword
                                )
                            }
                        )
                    }
                    entry <ResetPassword>{
                        ScreenResetPassword(
                            onResetSuccess = {
                                backstack.add(
                                    element = ResetPWSuccess
                                )
                            }
                        )
                    }
                    entry <ResetPWSuccess>{
                        ScreenResult()
                    }
                    entry <DashBoard>{
                        ScreenHomeDashBoard()
                    }
                    entry<MenuTransfer> {
                        ScreenMenuTransfer()
                    }
                    entry<TransferToOwnAccount> {
                        ScreenTransferToOwnAccount()
                    }
                }
            )
            DemoMobileBankingTheme {

            }
        }
    }
}

