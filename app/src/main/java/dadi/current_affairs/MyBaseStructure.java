package dadi.current_affairs;

/**
 * Created by Srinivas on 4/29/2017.
 */

public class MyBaseStructure {
    String channelname,channelsub,sortby;
    int channellogo;
    public MyBaseStructure(String channelname,int channellogo,String channelsub,String sortby) {
        this.channelname = channelname;this.channelsub = channelsub;
        this.channellogo = channellogo;this.sortby = sortby;
    }

    public String getSortby() {
        return sortby;
    }

    public int getChannellogo() {
        return channellogo;
    }

    public String getChannelname() {
        return channelname;
    }

    public String getChannelsub() {
        return channelsub;
    }
}
