// speed* min(reliability) problem

bool compare(const pair<int,int> &v1,const pair<int,int> &v2) {
    return v1.first > v2.first;
}

int mn(int a,int b,int c,vector<pair<int,int>> v) {
    int x = v[a].second;
    int y = v[b].second;
    int z = v[c].second;
    return (x<y && x<z)? a:((y<x && y<z)? b:c); //returnin the index
}
long maximumClusterQuality(vector<int> speed, vector<int> reliability, int maxMachines) {
    long res=0;
    int n = reliability.size();
    vector<pair<int,int>> v(n);
    l(i,n) {
        v[i] = make_pair(speed[i],reliability[i]);
    }
    sort(v.begin(),v.end(),compare);
    int pt[maxMachines];
    l(i,maxMachines) {
        pt[i] = i;
    }

    for(int i=maxMachines-1;i<n;i++) {
        int minI = mn(pt[0],pt[1],pt[2],v);

        res = max(res,long(v[pt[0]].first+v[pt[1]].first+v[pt[2]].first)*long(v[minI].second));
        if(i+1<n){
            pt[minI] = i+1;
        }
    }

    return res;
}
