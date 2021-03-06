/*
 * Copyright 2020 Java Programmer Indonesia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.youtubeplayer.util;

import java.util.HashMap;
import java.util.Map;
import com.youtubeplayer.Exception.Exceptions;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author rizal
 */
public class Environment {
    private final Exceptions exceptions = new Exceptions(this.getClass());
    private final String APPLICATION_NAME = "YoutubePlayer";
    private static Map<String, String> env;
    
    public String APP_NAME(){
        return APPLICATION_NAME;
    }
    public Environment(){
        if(env == null) initiateEnvironment();
    }
    private void initiateEnvironment(){
        try {
            FileReader reader=new FileReader("key.properties");  

            Properties p=new Properties();  
            p.load(reader);  
            
            env = new HashMap<>();
            //APP_NAME
            env.put("NAME", p.getProperty("NAME"));
            
            //API KEY
            env.put("KEY", p.getProperty("KEY"));
            
            //credential
            env.put("OAUTH", p.getProperty("OAUTH"));
            env.put("SECRET", p.getProperty("SECRET"));
        } catch (Exception e) {
            env = null;
            exceptions.log(e);
        }
        
    }
    
    public String get(String key){
        return env.get(key);
    }
}
