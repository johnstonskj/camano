package org.johnstonshome.camano

import java.util.ResourceBundle
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ConfigurationDelegate(val resourceName : String) {
  private var _bundle : ResourceBundle? = null
  init {
    _bundle = ResourceBundle.getBundle(resourceName)
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
    return _bundle!!.getString(property.name)
  }

}

class Configuration {
  private val delegate = ConfigurationDelegate("templates.configurations")
  val builders : String by delegate
}
