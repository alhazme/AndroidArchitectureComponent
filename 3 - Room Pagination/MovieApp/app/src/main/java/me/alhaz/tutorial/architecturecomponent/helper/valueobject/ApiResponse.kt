package me.alhaz.tutorial.architecturecomponent.helper.valueobject

import androidx.annotation.Nullable
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.SUCCESS
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.ERROR
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.EMPTY

class ApiResponse<T> (val status: Status, val body: T, val message: String) {

    companion object {

        fun <T> success(@Nullable body: T): ApiResponse<T> {
            return ApiResponse(SUCCESS, body, "")
        }

        fun <T> error(msg: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(ERROR, body, msg)
        }

        fun <T> empty(msg: String, @Nullable body: T): ApiResponse<T> {
            return ApiResponse(EMPTY, body, msg)
        }

    }


}