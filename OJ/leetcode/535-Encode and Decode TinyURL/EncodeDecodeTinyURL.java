
/**
 * Source : https://leetcode.com/problems/encode-and-decode-tinyurl/description/
 * Author : cloudy 
 * Date : 2018-7-27
 * 
 * Problem: 
 * TinyURL is a URL shortening service where you enter a URL 
 * such as https://leetcode.com/problems/design-tinyurl and 
 * it returns a short URL such as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. 
 * There is no restriction on how your encode/decode algorithm 
 * should work. You just need to ensure that a URL can be encoded
 *  to a tiny URL and the tiny URL can be decoded to the original URL.
 * 
 * solution:
 * 开放式的题目，没有具体的规则。原则就是encode->decode后，url要一致
 * 自定义短码的规则，数组中缓存longUrl,
 * 任何longUrl -> "0", 数组存的是longUrl, "0" -> 变为索引，0对应原来的 longUrl
 */

import java.util.ArrayList;

public class EncodeDecodeTinyURL {
    private ArrayList<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }

    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.decode(codec.encode(url));
    public static void main(String[] args) {
        EncodeDecodeTinyURL solution = new EncodeDecodeTinyURL();
        System.out.println(solution.decode(solution.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/description/")));
    }
}