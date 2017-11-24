package com.lxs.mms.rest.service.core.codec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.lxs.mms.rest.service.core.bean.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * 基于Gson的编解码器。<br/>
 * 将各个接口的业务响应封装成统一的对象{@link com.lxs.mms.rest.service.core.bean.Response}进行返回。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Provider
@Produces("application/json;charset=utf-8")
@Consumes({"application/json", "application/json;charset=utf-8"})
@Slf4j
public class GsonMessageProvider implements MessageBodyWriter<Object>,
        MessageBodyReader<Object> {
    private static Gson gson;

    private static Gson getGson() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.disableHtmlEscaping()
                    .setPrettyPrinting()
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
        }
        return gson;
    }


    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        boolean b = mediaType.getType().equalsIgnoreCase("application")
                && mediaType.getSubtype().equalsIgnoreCase("json");
        if (!b) {
            log.warn("未知的请求类型：{}，无法解码", mediaType);
        }
        return b;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType,
                           Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders,
                           InputStream entityStream)
            throws IOException, WebApplicationException {
        Type jsonType;
        if (type.equals(genericType)) {
            jsonType = type;
        } else {
            jsonType = genericType;
        }
        Object entity;
        try (InputStreamReader streamReader = new InputStreamReader(entityStream, "UTF-8")) {
            entity = getGson().fromJson(streamReader, jsonType);
        }
        IOUtils.closeQuietly(entityStream);
        return entity;
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        boolean b = mediaType.getType().equalsIgnoreCase("application")
                && mediaType.getSubtype().equalsIgnoreCase("json");
        if (!b) {
            log.warn("未知的请求类型：{}，无法编码", mediaType);
        }
        return b;
    }

    @Override
    public long getSize(Object o, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object o, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException,
            WebApplicationException {
        Type jsonType;
        if (type.equals(genericType)) {
            jsonType = type;
        } else {
            jsonType = genericType;
        }

        String json;
        if (o instanceof Response) {
            json = getGson().toJson(o, jsonType);
        } else {
            Response<Object> resp = new Response<>();
            resp.setData(o);
            resp.setStatus(Response.Status.SUCCESS);
            json = getGson().toJson(resp);
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(entityStream, "UTF-8")) {
            writer.write(json);
            writer.flush();
        }
    }
}

class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return new Date(json.getAsLong());
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.getTime());
    }
}
