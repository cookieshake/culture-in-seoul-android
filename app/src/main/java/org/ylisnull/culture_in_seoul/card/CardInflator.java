package org.ylisnull.culture_in_seoul.card;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ylisnull.culture_in_seoul.tool.HttpClient;

import java.io.IOException;
import java.util.ArrayList;

public class CardInflator {
    public ArrayList<CardContent> getCardContents() {
        final ArrayList<CardContent> al = new ArrayList<>();
        final HttpClient okHttpAdaptor = new HttpClient();

        Thread worker = new Thread() {
            @Override
            public void run() {
                String result = new String();

                try {
                    result = okHttpAdaptor.get("http://openapi.seoul.go.kr:8088/sample/json/SearchConcertDetailService/1/5");
                    JSONArray rows = new JSONObject(result).getJSONObject("SearchConcertDetailService").getJSONArray("row");

                    for (int i = 0; i < rows.length(); i++) {
                        CardContent cc = new CardContent();
                        JSONObject row = rows.getJSONObject(i);

                        cc.setCultcode(row.getString("CULTCODE"));
                        cc.setSubjcode(row.getString("SUBJCODE"));
                        cc.setCodename(row.getString("CODENAME"));
                        cc.setTitle(row.getString("TITLE"));
                        cc.setStrtdate(row.getString("STRTDATE"));
                        cc.setEnd_date(row.getString("END_DATE"));
                        cc.setTime(row.getString("TIME"));
                        cc.setPlace(row.getString("PLACE"));
                        cc.setOrg_link(row.getString("ORG_LINK"));
                        cc.setMain_img(row.getString("MAIN_IMG"));
                        cc.setHomepage(row.getString("HOMEPAGE"));
                        cc.setUse_trgt(row.getString("USE_TRGT"));
                        cc.setUse_fee(row.getString("USE_FEE"));
                        cc.setSponsor(row.getString("SPONSOR"));
                        cc.setInquiry(row.getString("INQUIRY"));
                        cc.setSupport(row.getString("SUPPORT"));
                        cc.setEtc_desc(row.getString("ETC_DESC"));
                        cc.setAgelimit(row.getString("AGELIMIT"));
                        cc.setIs_free(row.getString("IS_FREE"));
                        cc.setTicket(row.getString("TICKET"));
                        cc.setProgram(row.getString("PROGRAM"));
                        cc.setPlayer(row.getString("PLAYER"));
                        cc.setContents(row.getString("CONTENTS"));
                        cc.setGcode(row.getString("GCODE"));

                        al.add(cc);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        worker.start();
        try {
            worker.join();
        } catch (InterruptedException e) {
            al.clear();
        }

        return al;
    }

    //임시로 카드의 내용을 채우는 메소드
    public ArrayList<CardContent> getCardContents_temp() {
        ArrayList<CardContent> cardList = new ArrayList<>();

        CardContent _1 = new CardContent();
        _1.setTitle("巨木의 춤을 기억하다");
        _1.setStrtdate("2016-08-18");
        _1.setPlace("국립극장 해오름극장");
        _1.setMain_img("http://www.culture.go.kr/upload/rdf/show_201608129102727659.jpg");
        cardList.add(_1);

        CardContent _2 = new CardContent();
        _2.setTitle("괴테의대작속으로 1: 파우스트");
        _2.setStrtdate("2016-08-18");
        _2.setPlace("올림푸스홀");
        _2.setMain_img("http://www.culture.go.kr/upload/rdf/show_201608413275003248.jpg");
        cardList.add(_2);

        CardContent _3 = new CardContent();
        _3.setTitle("베이스 최공석 귀국독창회");
        _3.setStrtdate("2016-08-18");
        _3.setPlace("예술의전당 IBK챔버홀");
        _3.setMain_img("http://www.sacticket.co.kr/webhome/upload/20160728102904P.JPG");
        cardList.add(_3);

        CardContent _4 = new CardContent();
        _4.setTitle("코리안심포니 197회 정기연주회");
        _4.setStrtdate("2016-08-18");
        _4.setPlace("예술의전당 콘서트홀");
        _4.setMain_img("http://www.sacticket.co.kr/webhome/upload/20160701161052P.jpg");
        cardList.add(_4);

        CardContent _5 = new CardContent();
        _5.setTitle("2016 마티네 콘서트 - 시인의 사랑 (8월)");
        _5.setStrtdate("2016-08-18");
        _5.setPlace("성남아트센터 콘서트홀");
        _5.setMain_img("http://www.snart.or.kr/upload/image/20160314/9954B059F8AC487BA78C156D606FE050.jpg");
        cardList.add(_5);

        return cardList;
    }
}
