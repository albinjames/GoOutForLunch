package com.diegomfv.gooutforlunch.utils

const val CONNECTIVITY_INTENT_FILTER = "android.net.conn.CONNECTIVITY_CHANGE"

const val ITEM_ID = "itemId"

const val BASE_URL = ""

const val MANDATORY_MARKER = "*"

const val TAG_FRAGMENT_MAIN = "main_fragment_tag"
const val TAG_FRAGMENT_VIEWPAGER = "viewpager_fragment_tag"
const val TAG_FRAGMENT_ATTACHMENTS = "attachment_fragment_tag"
const val TAG_FRAGMENT_ADD_ATTACHMENTS = "add_attachments_fragment_tag"
const val TAG_FRAGMENT_TRIP = "trip_fragment_tag"
const val TAG_FRAGMENT_CSV = "csv_fragment_tag"


/** URLs
 * */
const val BASE_FIXER_URL = "http://data.fixer.io/"
const val FIXER_API_KEY = "03ff60406da98e32d43f38f80acf5569"

//const val pass = FIXERrefbus123098@@

/** Firebase keys / maps
 * */
const val TITLE = "title"
const val DATE = "date"
const val AMOUNT_IN_EUROS = "amountInEuros"
//const val CURRENCY_EURO = "currency"
const val AMOUNT_OTHER_CURRENCY = "amountOtherCurrency"
const val CODE_OTHER_CURRENCY = "codeOtherCurrency"
const val COUNTRY_OTHER_CURRENCY = "countryOtherCurrency"
const val PAYMENT_TYPE = "paymentType"
const val EXPENSE_TYPE = "expenseType"
const val DESCRIPTION = "description"
const val START_DATE = "startDate"
const val END_DATE = "endDate"
const val TRIP_CODE = "tripCode"
const val STATE = "state"
const val REFUSAL_REASON = "refusalReason"
const val LINK = "link"
const val ATTACHMENT_CODE = "attachmentCode"
const val ADMIN = "admin"
const val LAST_DATETIME = "lastDateTime"
const val USERNAME = "username"
const val EXCHANGE_RATE = "exchange_rate"
const val EXCHANGE_RATE_DATE = "exchange_rate_date"
const val EXCHANGE_RATE_BUTTON = "exchange_rate_button"

const val EURO_CONTAINER = "euro_container"
const val EXCHANGE_RATE_CONTAINER = "exchange_rate_container"
const val OTHER_CURRENCY_CONTAINER = "other_currency_container"

/** Shared Preferences
 * */
const val CONFIGURATION_PREFERENCES = "config_pref"
const val CONFIGURATION_USERNAME = "config_email"
const val CONFIGURATION_CURRENCIES = "config_currencies"

/** Firebase references
 * */
const val REF_ATTACHMENTS = "ref_attachments"
const val REF_ATTACHMENTS_STATE = "ref_attachments_state"

const val REF_TRIPS_ATTACHMENTS = "ref_trips_attachments"

const val REF_REFUSAL_REASONS = "ref_refusal_reasons"
const val REF_TRIPS = "ref_trips"

const val REF_USERS = "ref_users"
const val REF_USER_TRIPS = "ref_user_trips"

const val REF_REFUSAL_INFO = "ref_refusal_information"
const val REF_REFUSAL_REASONS_CODES = "ref_refusal_reasons_codes"

/** Files */
const val KEY_FILE_PATH = "key_file_path"

/** Dialog */
const val KEY_DATE_MOMENT = "key_date_moment"
const val KEY_ITEM_LIST_DIALOG = "key_item_list_dialog"
const val KEY_ITEM_SELECTED = "key_item_selected"
const val KEY_ATTACHMENT = "key_attachment"

/** Intent
 * */
const val INTENT_TRIP_CODE = "i_trip_code"

/** New Instance, fragments
 * */
const val NI_TRIP_CODE = "ni_trip_code"
const val KEY_AMOUNT = "amount__"
const val KEY_VALUE_TYPE = "value_type"

/** Request Code
 * */
const val REQUEST_CODE_SELECT_PICTURE = 145
const val REQUEST_CODE_TAKE_PHOTO = 146

/** Prepend, Append*/
const val ATTACHMENT_PRE = "att_"
const val PICTURE_PRE = "im_"
const val TRIP_PRE = "tr_"

const val ATTACHMENT_POST = "_att"
const val PICTURE_POST = "_im"
const val TRIP_POST = "_tr"

/** Progress vars */
const val START_PROGRESS_BAR_VALUE = 0f
const val END_PROGRESS_BAR_VALUE = 101f

const val SHOW_PROGRESS_LAYOUT = 1
const val HIDE_PROGRESS_LAYOUT = 0
const val INEFFECTIVE_PROGRESS_LAYOUT = 9999 //not affecting

/** Curency */
const val CURRENCY_EURO = "EUR"
const val CURRENCY_DOLLAR = "USD"
const val CURRENCY_POUND = "GBP"