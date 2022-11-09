package com.example.testapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "repositories")
data class Repositories(
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @Expose
    @SerializedName("name")
    val name: String?,

    @Expose
    @SerializedName("full_name")
    val fullName: String?,

    @Embedded
    @Expose
    @SerializedName("owner")
    val owner: Owner?,

    @Expose
    @SerializedName("description")
    val description: String?
) {
    data class Owner(

        @Expose
        @SerializedName("avatar_url")
        val avatarUrl: String?
    )
}

