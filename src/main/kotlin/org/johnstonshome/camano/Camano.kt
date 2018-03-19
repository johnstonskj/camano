/* Main tool entry */

package org.johnstonshome.camano

import java.util.ResourceBundle
import com.xenomachina.argparser.ArgParser

class CamanoArgs(parser: ArgParser) {
    val verbose by parser.flagging("-v", "--verbose",
            help = "enable verbose mode")
}

fun main(args: Array<String>) {
    val parsedArgs = ArgParser(args).parseInto(::CamanoArgs)
    val config = ResourceBundle.getBundle("templates.configurations")
    val builders = config.getString("builders").split(",\\s".toRegex())
    println(builders)

    val config2 = Configuration()
    println(config2.builders)
}
