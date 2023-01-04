package fr.modeetratheure.planmaster.utils.saves.json;

import fr.modeetratheure.planmaster.utils.PMLogger;

class PMJsonLogging {

    private static PMLogger logger;

    static{
        logger = new PMLogger(PMJsonLogging.class);
    }

    static void error(String mess){
        logger.error(mess);
    }

    static void warn(String mess){
        logger.warn(mess);
    }

    static void info(String mess){
        logger.info(mess);
    }

}
