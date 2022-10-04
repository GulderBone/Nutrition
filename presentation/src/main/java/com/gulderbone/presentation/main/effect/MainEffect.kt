package com.gulderbone.presentation.main.effect

sealed class MainEffect {

    object CheckPermission : MainEffect()

    object PermissionNotGranted : MainEffect()
}
