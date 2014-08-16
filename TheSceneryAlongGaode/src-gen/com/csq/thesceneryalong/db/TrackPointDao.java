package com.csq.thesceneryalong.db;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.csq.thesceneryalong.db.TrackPoint;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TRACK_POINT.
*/
public class TrackPointDao extends AbstractDao<TrackPoint, Long> {

    public static final String TABLENAME = "TRACK_POINT";

    /**
     * Properties of entity TrackPoint.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property TrackId = new Property(1, long.class, "trackId", false, "TRACK_ID");
        public final static Property Time = new Property(2, long.class, "time", false, "TIME");
        public final static Property Longitude = new Property(3, double.class, "longitude", false, "LONGITUDE");
        public final static Property Latitude = new Property(4, double.class, "latitude", false, "LATITUDE");
        public final static Property Altitude = new Property(5, Double.class, "altitude", false, "ALTITUDE");
        public final static Property Accuracy = new Property(6, Float.class, "accuracy", false, "ACCURACY");
        public final static Property Speed = new Property(7, Float.class, "speed", false, "SPEED");
        public final static Property Bearing = new Property(8, Float.class, "bearing", false, "BEARING");
        public final static Property Provider = new Property(9, String.class, "provider", false, "PROVIDER");
        public final static Property PointStatus = new Property(10, int.class, "pointStatus", false, "POINT_STATUS");
    };

    private DaoSession daoSession;

    private Query<TrackPoint> track_TrackPointsQuery;

    public TrackPointDao(DaoConfig config) {
        super(config);
    }
    
    public TrackPointDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TRACK_POINT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TRACK_ID' INTEGER NOT NULL ," + // 1: trackId
                "'TIME' INTEGER NOT NULL ," + // 2: time
                "'LONGITUDE' REAL NOT NULL ," + // 3: longitude
                "'LATITUDE' REAL NOT NULL ," + // 4: latitude
                "'ALTITUDE' REAL," + // 5: altitude
                "'ACCURACY' REAL," + // 6: accuracy
                "'SPEED' REAL," + // 7: speed
                "'BEARING' REAL," + // 8: bearing
                "'PROVIDER' TEXT," + // 9: provider
                "'POINT_STATUS' INTEGER NOT NULL );"); // 10: pointStatus
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TRACK_POINT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, TrackPoint entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getTrackId());
        stmt.bindLong(3, entity.getTime());
        stmt.bindDouble(4, entity.getLongitude());
        stmt.bindDouble(5, entity.getLatitude());
 
        Double altitude = entity.getAltitude();
        if (altitude != null) {
            stmt.bindDouble(6, altitude);
        }
 
        Float accuracy = entity.getAccuracy();
        if (accuracy != null) {
            stmt.bindDouble(7, accuracy);
        }
 
        Float speed = entity.getSpeed();
        if (speed != null) {
            stmt.bindDouble(8, speed);
        }
 
        Float bearing = entity.getBearing();
        if (bearing != null) {
            stmt.bindDouble(9, bearing);
        }
 
        String provider = entity.getProvider();
        if (provider != null) {
            stmt.bindString(10, provider);
        }
        stmt.bindLong(11, entity.getPointStatus());
    }

    @Override
    protected void attachEntity(TrackPoint entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public TrackPoint readEntity(Cursor cursor, int offset) {
        TrackPoint entity = new TrackPoint( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // trackId
            cursor.getLong(offset + 2), // time
            cursor.getDouble(offset + 3), // longitude
            cursor.getDouble(offset + 4), // latitude
            cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5), // altitude
            cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6), // accuracy
            cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7), // speed
            cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8), // bearing
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // provider
            cursor.getInt(offset + 10) // pointStatus
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, TrackPoint entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTrackId(cursor.getLong(offset + 1));
        entity.setTime(cursor.getLong(offset + 2));
        entity.setLongitude(cursor.getDouble(offset + 3));
        entity.setLatitude(cursor.getDouble(offset + 4));
        entity.setAltitude(cursor.isNull(offset + 5) ? null : cursor.getDouble(offset + 5));
        entity.setAccuracy(cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6));
        entity.setSpeed(cursor.isNull(offset + 7) ? null : cursor.getFloat(offset + 7));
        entity.setBearing(cursor.isNull(offset + 8) ? null : cursor.getFloat(offset + 8));
        entity.setProvider(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setPointStatus(cursor.getInt(offset + 10));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(TrackPoint entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(TrackPoint entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "trackPoints" to-many relationship of Track. */
    public List<TrackPoint> _queryTrack_TrackPoints(long trackId) {
        synchronized (this) {
            if (track_TrackPointsQuery == null) {
                QueryBuilder<TrackPoint> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TrackId.eq(null));
                queryBuilder.orderRaw("TIME ASC");
                track_TrackPointsQuery = queryBuilder.build();
            }
        }
        Query<TrackPoint> query = track_TrackPointsQuery.forCurrentThread();
        query.setParameter(0, trackId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getTrackDao().getAllColumns());
            builder.append(" FROM TRACK_POINT T");
            builder.append(" LEFT JOIN TRACK T0 ON T.'TRACK_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected TrackPoint loadCurrentDeep(Cursor cursor, boolean lock) {
        TrackPoint entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Track track = loadCurrentOther(daoSession.getTrackDao(), cursor, offset);
         if(track != null) {
            entity.setTrack(track);
        }

        return entity;    
    }

    public TrackPoint loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<TrackPoint> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<TrackPoint> list = new ArrayList<TrackPoint>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<TrackPoint> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<TrackPoint> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}