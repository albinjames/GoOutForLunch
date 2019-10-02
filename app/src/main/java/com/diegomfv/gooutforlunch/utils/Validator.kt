package com.diegomfv.gooutforlunch.utils

object Validator {

//    open class ErrorInValidationException(override val message: String?) : Exception(message)
//    class ErrorInTripValidationException (val blockerAttachments: List<AttachmentModel>, override val message: String?) : ErrorInValidationException(message)
//
//    val SUCCESSFUL = "Successful"
//
//    /** Throws an error if validation fails
//     * */
//    fun validateTrip(mapOfData: MutableMap<String, String>): Observable<MutableMap<String, String>> {
//        return Observable.just(mapOfData)
//            .flatMap { mapOfData ->
//                logCurrentThread()
//                SharedValidator.validateMandatory(mapOfData, TripValidator.getTool())
//                SharedValidator.validateFirebaseCharacters(mapOfData)
//                TripValidator.validateDatesTrip(mapOfData)
//                Observable.just(mapOfData)
//            }
//    }
//
//    fun validateAttachment(
//        mapOfData: MutableMap<String, String>,
//        tripModel: TripModel
//    ): Observable<MutableMap<String, String>> {
//        return Observable.just(mapOfData)
//            .flatMap { mapOfData ->
//                logCurrentThread()
//                SharedValidator.validateMandatory(mapOfData, AttachmentsValidator.getTool())
//                SharedValidator.validateFirebaseCharacters(mapOfData)
//                AttachmentsValidator.validateDatesAttachment(mapOfData, tripModel)
//                AttachmentsValidator.validateTypesMatch(mapOfData)
//                Observable.just(mapOfData)
//            }
//    }
//
//    fun validateRefusalReason(refusalReason: String) : Observable<String> {
//        return Observable.just(refusalReason)
//            .flatMap {
//                SharedValidator.validateFirebaseCharacters(mutableMapOf(REFUSAL_REASON to it))
//                Observable.just(it)
//            }
//    }
//
//    fun validateState (newState: Int) : Observable<Int> {
//        return Observable.just(newState)
//            .flatMap {
//                when (newState) {
//                    0,1,2 -> Observable.just(newState)
//                    else -> throw ErrorInValidationException("State not valid") //do not need to be translated
//                }
//            }
//    }
//
//    object SharedValidator {
//
//        fun validateMandatory(mapOfData: MutableMap<String, String>, tool: Map<String, InputValidator>) {
//            mapOfData.forEach { (key, value) ->
//                if (tool[key]?.mandatory == MandatoryType.MANDATORY
//                    && value.isEmpty()
//                ) throw ErrorInValidationException(
//                    ApplicationResourceProvider.getString(
//                        R.string.x_is_mandatory,
//                        Translator.translateKey(key).capitalize()
//                    )
//                )
//            }
//        }
//
//        fun validateFirebaseCharacters(mapOfData: MutableMap<String, String>) {
//            mapOfData.forEach { k, v ->
//                if (k != AMOUNT_IN_EUROS
//                    && k != AMOUNT_OTHER_CURRENCY
//                    && k != EXCHANGE_RATE
//                ) {
//                    if (!FirebaseUtils.allCharInStringAreValidForFirebase(v))
//                        throw ErrorInValidationException(
//                            ApplicationResourceProvider.getString(
//                                R.string.x_has_invalid_characters,
//                                v
//                            )
//                        )
//                }
//            }
//        }
//
//        fun validateDateFormat(dateEntry: MutableMap.MutableEntry<String, String>) {
//            val df = SimpleDateFormat(DateUtils.datePattern)
//            try {
//                df.parse(dateEntry.value)
//            } catch (e: java.lang.Exception) {
//                throw ErrorInValidationException(
//                    ApplicationResourceProvider.getString(
//                        R.string.x_is_mandatory,
//                        dateEntry.key.capitalize()
//                    )
//                )
//            }
//        }
//    }
//
//
//    object TripValidator {
//
//        fun getTool(): Map<String, InputValidator> {
//            return mapOf<String, InputValidator>(
//                TITLE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                START_DATE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                END_DATE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                DESCRIPTION to InputValidator()
//            )
//        }
//
//        fun validateDatesTrip(mapOfData: MutableMap<String, String>) {
//            val mapEntryStartDate = mapOfData.entries.find { it.key == START_DATE }
//                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.start_date_is_null))
//            val mapEntryEndDate = mapOfData.entries.find { it.key == END_DATE }
//                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.end_date_is_null))
//
//            SharedValidator.validateDateFormat(mapEntryStartDate)
//            SharedValidator.validateDateFormat(mapEntryEndDate)
//
//            validateStartDateBeforeEndDate(mapEntryStartDate.value to mapEntryEndDate.value)
//
//        }
//
//        private fun validateStartDateBeforeEndDate(dateEntries: Pair<String, String>) {
//            Timber.i("VALIDATION_: first ->  ${dateEntries.first}")
//            Timber.i("VALIDATION_: second -> ${dateEntries.second}")
//            if (DateUtils.transformDateAsStringToMillis(dateEntries.first) > DateUtils.transformDateAsStringToMillis(
//                    dateEntries.second
//                )
//            )
//                throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.end_date_is_before_start_date))
//        }
//    }
//
//
//    object AttachmentsValidator {
//
//        fun getTool(): Map<String, InputValidator> {
//            return mapOf<String, InputValidator>(
//                TITLE to InputValidator(),
//                AMOUNT_IN_EUROS to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                AMOUNT_OTHER_CURRENCY to InputValidator(),
//                CODE_OTHER_CURRENCY to InputValidator(),
//                EXPENSE_TYPE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                PAYMENT_TYPE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                DATE to InputValidator().apply { this.mandatory = MandatoryType.MANDATORY },
//                DESCRIPTION to InputValidator(),
//                STATE to InputValidator()
//            )
//        }
//
//        fun validateDatesAttachment(mapOfData: MutableMap<String, String>, tripModel: TripModel) {
//            val mapEntryDate = mapOfData.entries.find { it.key == DATE }
//                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.start_date_is_null))
//
//            SharedValidator.validateDateFormat(mapEntryDate)
//            validateDateBetweenTripsDate(mapEntryDate.value, tripModel)
//
//        }
//
//        private fun validateDateBetweenTripsDate(dateAsString: String, tripModel: TripModel) {
//            Timber.i("VALIDATION_:  ${dateAsString}")
//
//            tripModel.startDate?.let { tripStartDate ->
//                tripModel.endDate?.let { tripEndDate ->
//
//                    if (DateUtils.transformDateAsStringToMillis(dateAsString) < DateUtils.transformDateAsStringToMillis(
//                            tripStartDate
//                        )
//                    )
//                        throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.attachment_date_is_before_trip_start_date))
//
//                    if (DateUtils.transformDateAsStringToMillis(dateAsString) > DateUtils.transformDateAsStringToMillis(
//                            tripEndDate
//                        )
//                    )
//                        throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.attachment_date_is_after_trip_end_date))
//
//                }
//            }
//        }
//
//        //TODO
//        fun validateTypesMatch(mapOfData: MutableMap<String, String>) {
//            val mapEntryExpenseType = mapOfData.entries.find { it.key == EXPENSE_TYPE }
//                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.expense_type_is_null))
//            val mapEntryPaymentType = mapOfData.entries.find { it.key == PAYMENT_TYPE }
//                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.payment_type_is_null))
////            val mapEntryCurrency = mapOfData.entries.find { it.key == CURRENCY_EURO }
////                ?: throw ErrorInValidationException(ApplicationResourceProvider.getString(R.string.currency_is_null))
//
//            validateType(mapEntryExpenseType.value, enumValues<ExpenseType>())
//            validateType(mapEntryPaymentType.value, enumValues<PaymentType>())
////            validateType(mapEntryCurrency.value, enumValues<Currency>())
//
//        }
//
//        inline fun <reified T> validateType(value: String, enumValues: Array<T>) {
//            var valid = false
//            enumValues.forEach {
//                if (it.toString().equals(value, true)) valid = true
//            }
//            if (!valid) throw ErrorInValidationException(
//                ApplicationResourceProvider.getString(
//                    R.string.x_value_is_not_valid,
//                    T::class.java.simpleName
//                )
//            )
//        }
//    }
}