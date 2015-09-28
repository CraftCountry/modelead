package com.djlead.leadmod.sys;

import com.djlead.leadmod.Reference;
import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

/** LogOut - Helper file to output to console with Modid prefix
 * Created by Lead on 26-9-2015.
 */
public class LogOut {

    // LogOut.info("Init Complete");
    public static void log(Level logLevel, Object object) {
        FMLLog.log(Reference.MODID, logLevel, String.valueOf(object));
    }

    // possible outputs :
    public static void error(Object object) {log(Level.ERROR, object);}

    public static void fatal(Object object) {log(Level.FATAL, object);}

    public static void info(Object object) {log(Level.INFO, object);}

}
