package com.example.test.service;
 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
 
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.TwitterCredentialsBearer;
import com.twitter.clientlib.api.TwitterApi;
 
@Service
public class TwitterServiceImpl {
     
    @Value("${twitter.api.bearerToken}")
    private String bearerToken;
     
    private TwitterApi createTwitterApiInstance() {
        TwitterCredentialsBearer credentials = new TwitterCredentialsBearer(this.bearerToken);
        TwitterApi apiInstance = new TwitterApi(credentials);
        return apiInstance;
    }
     
    private InputStream sampleStream() throws ApiException {
        TwitterApi apiInstance = this.createTwitterApiInstance();
        Set<String> tweetFields = new HashSet<>();
        tweetFields.add("author_id");
        tweetFields.add("id");
        tweetFields.add("created_at");
        tweetFields.add("geo");
        Set<String> expansions = new HashSet<>();
        expansions.add("geo.place_id");
        Set<String> placeFields = new HashSet<>();
        placeFields.add("geo");
        placeFields.add("id");
        placeFields.add("name");
        placeFields.add("place_type");
 
        return apiInstance.tweets().sampleStream()
        .backfillMinutes(0)
        .tweetFields(tweetFields).expansions(expansions).placeFields(placeFields)
        .execute();     
    }
     
    public List<String> queueTweets() {
        String line = null;
        List<String> twitteList = new ArrayList<>();
        BigInteger count = BigInteger.ZERO;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.sampleStream()))) {
            while ((line = reader.readLine()) != null) {
                count = count.add(BigInteger.ONE);
                if (count.compareTo(new BigInteger("1")) >= 0) {
                    break;
                }
                System.out.print(count);
                System.out.println(line);
                twitteList.add(line);
            }
             
        } catch (ApiException e) {
            System.out.println(e);
        } catch(InterruptedIOException e) {
             
        } catch(Exception e) {
             
        }
        return twitteList;
    }
     
}