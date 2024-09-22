package net.dolphinhttp.http;

import fi.iki.elonen.NanoHTTPD;

import net.dolphinhttp.utils.MIMETypeCheck;
import net.dolphinhttp.utils.Console;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpServer extends NanoHTTPD {
    private final File publicFolder;
    private final MIMETypeCheck mimeTypeCheck;
    private final Console console = new Console();

    public HttpServer(int port) throws IOException {
        super(port);
        this.publicFolder = new File("./public");
        this.mimeTypeCheck = new MIMETypeCheck();
        ensurePublicFolderExists();
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
    }

    private void ensurePublicFolderExists() {
        if (!publicFolder.exists()) {
            publicFolder.mkdir();
        }
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();

        File requestedFile = getRequestedFile(uri);
        if (requestedFile.exists()) {
            try {
                return serveFile(requestedFile, session);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            console.log("Request Method: " + session.getMethod() + ", Request URI: " + session.getUri() + ", Remote IP: " + session.getRemoteIpAddress() + ", Response: 404 Not Found", true);
            return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "404 Not Found");
        }
    }

    private File getRequestedFile(String uri) {
        if ("/".equals(uri)) {
            return new File(publicFolder, "index.html");
        } else {
            File file = new File(publicFolder, uri);
            if (file.isDirectory()) {
                return new File(file, "index.html");
            }
            return file;
        }
    }

    private Response serveFile(File file, IHTTPSession session) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        String mimeType = mimeTypeCheck.Check(file.getName());

        console.log("Request Method: " + session.getMethod() + ", Request URI: " + session.getUri() + ", Remote IP: " + session.getRemoteIpAddress() + ", Response: 200 OK", true);
        return newFixedLengthResponse(Response.Status.OK, mimeType, fileInputStream, file.length());
    }
}