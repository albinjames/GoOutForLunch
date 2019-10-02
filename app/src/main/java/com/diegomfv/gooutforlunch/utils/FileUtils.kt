package com.diegomfv.gooutforlunch.utils

import android.app.Application
import android.graphics.Bitmap
import android.graphics.Matrix
import androidx.exifinterface.media.ExifInterface
import com.diegomfv.gooutforlunch.utils.applicationprovider.ApplicationProvider
import com.diegomfv.gooutforlunch.utils.extensions.floatTo2Decimals
import java.io.*

object FileUtils {

    const val TEMP_PHOTO_PATH = "temp_photo_path"

    private fun getCacheDir() = ApplicationProvider.application.cacheDir

    fun getTemporaryPictureFilePath() = ""
        .plus(getCacheDir())
        .plus(File.separator)
        .plus(TEMP_PHOTO_PATH)

    fun getTemporaryPictureFile(): File? {
        return getCacheDir().listFiles().find { it.name.contains(TEMP_PHOTO_PATH) }
    }

    fun createTemporaryPictureFile(arrayOfBytes: ByteArray): Boolean {
        val file = File.createTempFile(TEMP_PHOTO_PATH, ".jpeg", getCacheDir())
        return try {
            val fos = FileOutputStream(file)
            fos.write(arrayOfBytes)
            fos.close()
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun createTemporaryPictureFile(baos: ByteArrayOutputStream): Boolean {
        val file = File.createTempFile(TEMP_PHOTO_PATH, ".jpeg", getCacheDir())
        return try {
            val fos = FileOutputStream(file)
            baos.writeTo(fos)
            baos.close()
            fos.close()
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun deleteTemporaryPictureFile(): Boolean {
        val files = getCacheDir().listFiles().filter { it.absolutePath.contains(TEMP_PHOTO_PATH) }
        var deleted = false
        files.forEach {
            if (!it.isDirectory) {
                it.delete()
                deleted = true
            }
        }
        return deleted
    }

    fun getAllFilesInCache(app: Application): List<File> {
        return getCacheDir().listFiles().toList()
    }

    fun getAllFilesAndFilesSizeInCache(app: Application): Pair<String, String> {
        val cacheDir = app.cacheDir
        val files = cacheDir.listFiles()
        val totalFilesSizeInBytes =
            ((files.map { if (!it.isDirectory) it.readBytes().size else 0 }.toIntArray().sum().toFloat()) / (1024 * 1024)).floatTo2Decimals()
        return files.size.toString() to totalFilesSizeInBytes.toString()
    }

    fun getAttachmentFile(app: Application, filename: String): File? {
        val cacheDir = app.cacheDir
        val files = cacheDir.listFiles()
        return files.find { it.path.toString().contains(filename) }
    }

    fun dropCache(app: Application): Int {
        val cacheDir = app.cacheDir
        val files = cacheDir.listFiles()
        var counter = 0
        files.forEach {
            if (!it.isDirectory) {
                it.delete(); counter++
            }
        }
        return counter
    }

    fun getFileExtension(filePath: String): String {
        return filePath.substring(filePath.lastIndexOf(".") + 1, filePath.length)
    }

    fun rotateBitmap(bitmap: Bitmap, orientation: Int): Bitmap? {

        val matrix = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_NORMAL -> return bitmap
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.setScale(-1f, 1f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.setRotate(180f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> {
                matrix.setRotate(180f)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_TRANSPOSE -> {
                matrix.setRotate(90f)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.setRotate(90f)
            ExifInterface.ORIENTATION_TRANSVERSE -> {
                matrix.setRotate(-90f)
                matrix.postScale(-1f, 1f)
            }
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.setRotate(-90f)
            else -> return bitmap
        }
        try {
            val bmRotated =
                Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
            bitmap.recycle()
            return bmRotated
        } catch (e: OutOfMemoryError) {
            e.printStackTrace()
            return null
        }
    }

    fun copy(originalFileDir: String, originalFileNameWithExt: String, newFileDir: String, newFileNameWithExt: String
    ): String {
        val file = File(originalFileDir, originalFileNameWithExt)
            .copyTo(File(newFileDir, newFileNameWithExt), true)
        return file.path
    }

}