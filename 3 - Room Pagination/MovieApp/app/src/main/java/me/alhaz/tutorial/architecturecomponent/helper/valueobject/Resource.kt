package me.alhaz.tutorial.architecturecomponent.helper.valueobject

import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.SUCCESS
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.ERROR
import me.alhaz.tutorial.architecturecomponent.helper.valueobject.Status.EMPTY

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(ERROR, data, msg)
        }

        fun <T> empty(data: T?): Resource<T> {
            return Resource(EMPTY, data, null)
        }
    }
}