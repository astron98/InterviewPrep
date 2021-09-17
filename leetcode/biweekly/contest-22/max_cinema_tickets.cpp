class Solution {
public:
    static bool sortfun( const vector<int>& v1,const vector<int>& v2 ) { 
     return v1[0] < v2[0]; 
    } 
    
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        int p=0,count=0;
        sort(reservedSeats.begin(),reservedSeats.end(),sortfun);
        
        for(int i=1;i<=n;i++)
        {
            int a[11]={0};
            while(reservedSeats[p][0]==i && p<reservedSeats.size())
            {
                int x = reservedSeats[p][1];
                a[x] = 1;
                p++;
            }
            
            if(a[2] || a[3] || a[8] || a[9])
            {
                if(a[4] || a[5] || a[6] || a[7])
                    continue;
                else
                    count++;
            }
            else
            {
                if(a[4]==0 && a[5]==0)
                    count++;
                if(a[6]==0 && a[7]==0)
                    count++;
            }
        }
        return count;
    }
};
