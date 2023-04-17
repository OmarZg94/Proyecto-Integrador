package com.omar_zuniga.proyectointegrador.data

import com.omar_zuniga.proyectointegrador.data.model.LoggedInUser
import java.io.IOException
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            val fakeUser = LoggedInUser("test@uvm.com", "Omar Zúñiga")
            if (username == fakeUser.userId && password == "Azul3j0s@")
                Result.Success(fakeUser) else Result.Error(Exception("Invalid credentials"))
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}