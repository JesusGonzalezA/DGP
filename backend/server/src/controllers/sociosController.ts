import { Request, Response } from 'express';

import pool from '../database'

class SociosController {

    public async list (req: Request, res: Response): Promise<void> {
        await pool.query('SELECT * FROM socios', function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }

    public async getOne (req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        await pool.query('SELECT * FROM socios WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            if (result.length > 0) {
                return res.json(result[0]);
            }
            res.status(404).json({message: "El socio no existe"});
        });
    }

    public async create (req: Request, res: Response): Promise<void> {
        await pool.query('INSERT INTO socios set ?', [req.body]);
        res.json({message: 'Socio creado'});
    }

    public async delete (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('DELETE FROM socios WHERE id=?',[id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "El socio fue eliminado"});
        });
    }

    public async update (req: Request, res: Response): Promise<void> {
        const id = req.params;
        await pool.query('UPDATE socios set ? WHERE id=?',[req.body, id], function(err, result, fields) {
            if (err) throw err;
            res.json({message: "El socio fue actualizado"});
        });
    }


}

export const sociosController = new SociosController();