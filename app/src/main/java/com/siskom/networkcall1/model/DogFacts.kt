package com.siskom.networkcall1.model

import com.google.gson.annotations.SerializedName

data class DogFacts(

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("facts")
	val facts: List<String?>? = null
)
