package me.alhaz.tutorial.architecturecomponent.helper.valueobject

import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.SUCCESS
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.ERROR
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.EMPTY

class ApiResponse<T> (val status: Status, val body: T?, val message: String?) {

    companion object {

        fun <T> success(body: T): ApiResponse<T> {
            return ApiResponse(SUCCESS, body, "")
        }

        fun <T> error(msg: String, body: T?): ApiResponse<T> {
            return ApiResponse(ERROR, body, msg)
        }

        fun <T> empty(msg: String, body: T?): ApiResponse<T> {
            return ApiResponse(EMPTY, body, msg)
        }

    }


}