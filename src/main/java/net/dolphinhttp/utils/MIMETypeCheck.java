package net.dolphinhttp.utils;

public class MIMETypeCheck {
    /**
     * Checks the mime type of file, supports only .json, .ttf, .css, .js, .png, .html, other files will return octet-stream
     * @param filename The filename to check
     * @return The mime type of the file
     */
    public String Check(String filename){
        if (filename.contains(".css")){
            return "text/css";
        } else if (filename.contains(".js")){
            return "application/javascript";
        } else if (filename.contains(".json")){
            return "application/json";
        } else if (filename.contains(".ttf")){
            return "font/ttf";
        } else if (filename.contains(".html")){
            return "text/html";
        } else if (filename.contains(".png")){
            return "image/png";
        } else {
            return "application/octet-stream";
        }
    }
}
